package com.haut.music.controller;

import com.haut.music.dao.RecordPlayDao;
import com.haut.music.service.RecordPlayService;
import com.haut.music.service.impl.RecordPlayServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Evan
 * @Description:
 * @Date: Created in 9:38 2019/4/23
 * @Modified By:
 */


public class RecordPlayControllerTest extends TestCase {
   @Autowired
   private RecordPlayServiceImpl recordPlayService;

   @RequestMapping("recordPlay.do")
   @Test
    public void testRecordPlay() throws Exception{

       //HttpServletRequest request=;

       //RecordPlayDao recordPlayDao=recordPlayService.recordPlay(request,3);

    }
}