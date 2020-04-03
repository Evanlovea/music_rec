package com.haut.music.recommenders;

import com.github.chen0040.tensorflow.recommenders.models.AudioUserHistory;
import com.github.chen0040.tensorflow.recommenders.models.KnnAudioRecommender;
import com.github.chen0040.tensorflow.search.models.AudioSearchEntry;
import com.haut.music.utils.FileUtils;

import java.io.File;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Evan
 * @Description:
 * @Date: Created in 14:50 2019/5/31
 * @Modified By:
 */

//向用户推荐音乐功能实现
public class MusicRecommenderDemo {

    public static void main(String[] args) {
        //构建用户历史浏览记录
        AudioUserHistory userHistory = new AudioUserHistory();
        //获得music_samples中所有的以.au结尾的文件链表
        //其中会在控制台输出所有的文件
        List<String> audioFiles = FileUtils.getAudioFiles();
        //使用默认随机源对列表进行置换，所有置换发生的可能性都是大致相等的。
        Collections.shuffle(audioFiles);

        for(int i=0; i < 40; ++i){
            //遍历获得每个音乐文件的路径
            String filePath = audioFiles.get(i);
            //在用户浏览记录中添加该路径
            userHistory.logAudio(filePath);
            try {
                //线程休眠（暂停占用CPU）100毫秒
                // 主要是你的软件设置的时间问题
                // 这个软件设置不能大于2000.
                Thread.sleep(100L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        KnnAudioRecommender recommender = new KnnAudioRecommender();
        //如果该索引不存在
        if(!recommender.loadIndexDbIfExists()) {
            //将music_sample文件夹下面的文件都添加索引
            recommender.indexAll(new File("src/main/webapp/track/song").listFiles(a -> a.getAbsolutePath().toLowerCase().endsWith(".au")));
            //保存
            recommender.saveIndexDb();
        }
        //打印前十个索引文件
        System.out.println(userHistory.head(10));

        int k = 10;
        //根据历史记录进行推荐
        List<AudioSearchEntry> result = recommender.recommends(userHistory.getHistory(), k);

        for(int i=0; i < result.size(); ++i){
            AudioSearchEntry entry = result.get(i);
            System.out.println("Search Result #" + (i+1) + ": " + entry.getPath());
        }




    }
}
