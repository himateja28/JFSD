package klu.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

@Service
public class CaptchaManager {
	
	public String generateText(int captchaLength) {
		String captcha="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuffer captchaBuffer=new StringBuffer();
		Random rnd=new Random();
		while(captchaBuffer.length() < captchaLength) {
			int idx=(int)((rnd.nextFloat()) * captcha.length());
			captchaBuffer.append(captcha.substring(idx, idx+1));
		}
		
		return captchaBuffer.toString();
	}
	
	public byte[] generateCaptcha(int captchaLength) {
		String captchaText=generateText(captchaLength);
		int width=160,height =35;
		
		BufferedImage image =new BufferedImage(width, height, BufferedImage.OPAQUE);
		Graphics graphics=image.createGraphics();
		graphics.setFont(new Font("Arial", Font.BOLD, 20));
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(0, 0, width, height);
		graphics.setColor(Color.yellow);
		graphics.drawString(captchaText, 20, 25);
		
		ByteArrayOutputStream bout=new ByteArrayOutputStream();
		try {
		ImageIO.write(image, "png", bout);
		}catch(Exception e) {
			throw new RuntimeException();
		}
		return bout.toByteArray();
	}
}
