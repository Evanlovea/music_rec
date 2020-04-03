package com.haut.music.audio;

import com.github.chen0040.tensorflow.classifiers.models.resnet.ResNetV2AudioClassifier;

import com.haut.music.utils.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Evan
 * @Description:
 * @Date: Created in 15:06 2019/5/11
 * @Modified By:
 */

//使用resnetv2深度学习模型作音乐分类
public class ResNetV2AudioClassifierDemo {
    private static final Logger logger = LoggerFactory.getLogger(ResNetV2AudioClassifierDemo.class);



    public static void main(String[] args) throws IOException {
        ResNetV2AudioClassifier classifier = new ResNetV2AudioClassifier();
        classifier.load_model();

        //List<String> paths = FileUtils.getAudioFiles();
        List<String> paths = FileUtils.getAudioFiles();
        Collections.shuffle(paths);

        for (String path : paths) {
            System.out.println("Predicting " + path + " ...");
            File f = new File(path);
            String label = classifier.predict_audio(f);

            System.out.println("Predicted: " + label);
        }
    }
}
