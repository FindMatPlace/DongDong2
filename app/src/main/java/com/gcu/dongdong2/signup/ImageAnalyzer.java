package com.gcu.dongdong2.signup;

import static android.content.ContentValues.TAG;

import static com.gcu.dongdong2.signup.VerifyCodeFragment.AUTH;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.media.Image;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.OptIn;
import androidx.camera.core.ExperimentalGetImage;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.ml.vision.FirebaseVision;
import com.google.firebase.ml.vision.common.FirebaseVisionImage;
import com.google.firebase.ml.vision.common.FirebaseVisionImageMetadata;
import com.google.firebase.ml.vision.text.FirebaseVisionText;
import com.google.firebase.ml.vision.text.FirebaseVisionTextRecognizer;
import com.google.firebase.ml.vision.text.RecognizedLanguage;

import java.io.IOException;
import java.util.List;

@ExperimentalGetImage
public class ImageAnalyzer implements ImageAnalysis.Analyzer {

    public Boolean flag = false;
    private VerifyCodeFragment verifyCodeFragment;

    public void setVerifyCodeFragment(VerifyCodeFragment fragment) {
        verifyCodeFragment = fragment;
    }

    // 싱글톤 구현
    private static ImageAnalyzer imageAnalyzer = new ImageAnalyzer();
    private ImageAnalyzer() {};

    public static ImageAnalyzer getInstance() {
        return imageAnalyzer;
    }

    @Override
    public void analyze(@NonNull ImageProxy imageProxy) {
        //
    }

    public Task<FirebaseVisionText> imageAnalyze(Context context, Uri uri) {
        FirebaseVisionImage image;
        FirebaseVisionTextRecognizer recognizer = FirebaseVision.getInstance()
                .getCloudTextRecognizer();
        try {
            image = FirebaseVisionImage.fromFilePath(context, uri);
            FirebaseVisionTextRecognizer detector = FirebaseVision.getInstance()
                    .getOnDeviceTextRecognizer();

            detector.processImage(image);
            Task<FirebaseVisionText> result =
                    detector.processImage(image)
                            .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                                @Override
                                public void onSuccess(FirebaseVisionText firebaseVisionText) {
                                    // Task completed successfully
                                    // ...
                                    recognizer.processImage(image)
                                            .addOnSuccessListener(new OnSuccessListener<FirebaseVisionText>() {
                                                @Override
                                                public void onSuccess(FirebaseVisionText result) {
                                                    StringBuilder stringBuilder = new StringBuilder();
                                                    for (FirebaseVisionText.TextBlock block : result.getTextBlocks()) {
                                                        for (FirebaseVisionText.Line line : block.getLines()) {
                                                            for (FirebaseVisionText.Element element : line.getElements()) {
                                                                stringBuilder.append(element.getText()).append(" ");
                                                            }
                                                            stringBuilder.append("\n");
                                                        }
                                                        stringBuilder.append("\n");
                                                    }
                                                    String extractedText = stringBuilder.toString().trim();
                                                    if (extractedText.contains("가천")) {
                                                        if (verifyCodeFragment != null) {
                                                            verifyCodeFragment.savedStateHandle.set(AUTH, true);
                                                        }
                                                        flag = true;
                                                        Toast.makeText(context, "가천대학교 학생 인증 완료!", Toast.LENGTH_LONG).show();
                                                        Log.d(TAG, "인증 성공!");
                                                    }
                                                    System.out.println(extractedText);
                                                }
                                            })
                                            .addOnFailureListener(new OnFailureListener() {
                                                @Override
                                                public void onFailure(@NonNull Exception e) {
                                                    // Handle failure
                                                }
                                            });
                                }
                            })
                            .addOnFailureListener(
                                    new OnFailureListener() {
                                        @Override
                                        public void onFailure(@NonNull Exception e) {
                                            // Task failed with an exception
                                            Toast.makeText(context, "인증에 실패하셨습니다", Toast.LENGTH_LONG);
                                            Log.e(TAG, "인증 실패");
                                        }
                                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Tasks.forException(new Exception("Image analysis failed."));
    }

}
