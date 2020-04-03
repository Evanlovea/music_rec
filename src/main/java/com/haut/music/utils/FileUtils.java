package com.haut.music.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Evan
 * @Description:
 * @Date: Created in 9:33 2019/5/15
 * @Modified By:
 */


public class FileUtils {
    public static List<String> getAudioFiles() {
        List<String> result = new ArrayList<>();
        //File dir = new File("music_samples");
        File dir=new File("src/main/webapp/track/song");
        System.out.println(dir.getAbsolutePath());
        if (dir.isDirectory()) {

            for (File f : dir.listFiles()) {
                String file_path = f.getAbsolutePath();
                if (file_path.toLowerCase().endsWith("mp3")) {
                    result.add(file_path);

                }
            }
        }

        return result;
    }
}
