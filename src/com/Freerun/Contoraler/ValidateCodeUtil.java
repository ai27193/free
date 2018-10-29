package com.Freerun.Contoraler;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
@Controller
@SessionAttributes(value={"validte_code"})  
public class ValidateCodeUtil{
	
	public  ValidateCodeUtil(){
		System.out.println("this is ValidateCodeUtil");
		
	}
	/*
	 * 生成验证码
	 */
	@RequestMapping("/generate")
	public void generateCode(HttpServletResponse response, ModelMap model){
		BufferedImage bi = new BufferedImage(90, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		Color c = new Color(200, 200, 255);
		g.setColor(c);
		g.fillRect(0, 0, 90, 30);
		
		// 定义验证码字符数组
        char[] ch = "ABCDEFGHIJKLMNPQRSTUVWXYZ0123456798".toCharArray();
        StringBuffer sbuf = new StringBuffer(); 
        Random rand = new Random();
        for(int i=0; i<4; i++){
        	int index = rand.nextInt(ch.length);
        	g.setColor(new Color(rand.nextInt(22), rand.nextInt(33), rand.nextInt(66)));
            @SuppressWarnings("unused")
			Font font = new Font("Times New Roman", Font.ITALIC, 20);
            g.drawString(ch[index] + "", (i * 20) + 5, 20);
            sbuf.append(ch[index]);
        }
        // 禁止缓存  
        response.setHeader("Pragma", "No-cache");  
        response.setHeader("Cache-Control", "No-cache");  
        response.setDateHeader("Expires", 0);  
        // 指定生成的响应是图片  
        response.setContentType("image/jpeg");        
        //通过ModelMap将validat_code加入 @SessionAttributes
        model.addAttribute("validte_code", sbuf.toString()); 
        ServletOutputStream sos=null;
		try {
			sos = response.getOutputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try{
        	ImageIO.write(bi, "JPG", sos);
        	sos.flush();
        	sos.close();
        	System.out.println("关闭");
        }catch(IOException e){
        	e.printStackTrace();
        }
        finally {
        	try {
				sos.flush();
				sos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
		}
	}			
}
