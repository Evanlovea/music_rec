package com.haut.music.audio;

import com.github.chen0040.tensorflow.classifiers.models.cifar10.Cifar10AudioClassifier;
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
 * @Date: Created in 14:34 2019/5/11
 * @Modified By:
 */

//音乐分类器，为音乐打上标签
public class Cifar10AudioClassifierDemo {
    private static final Logger logger = LoggerFactory.getLogger(Cifar10AudioClassifierDemo.class);



    public static void main(String[] args) throws IOException {
        Cifar10AudioClassifier classifier = new Cifar10AudioClassifier();
        classifier.load_model();

        // List<String> paths = FileUtils.getAudioFiles();
        List<String> paths=FileUtils.getAudioFiles();

        Collections.shuffle(paths);

        for (String path : paths) {
            System.out.println("Predicting " + path + " ...");
            File f = new File(path);
            String label = classifier.predict_audio(f);

            System.out.println("Predicted: " + label);
        }
    }
}
