package com.esri.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.json.JSONObject;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.opensymphony.xwork2.ActionSupport;
//配置多例
@Scope("prototype")

@Repository
public class CreateImageAction extends ActionSupport{
	
	public CreateImageAction() {
		super();
	}

	public HttpServletRequest req = ServletActionContext.getRequest();
	
	private static final long serialVersionUID = 1L;

	public static String checkCode;

	private ByteArrayInputStream inputStream;
	//验证码长
	private static int length = 60;
	//验证码宽
	private static int width = 20;
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	/**
	 * 产生四位随机数
	 * @return
	 */
	private String createRandom() {
		String str = "0123456789abcdefghijklmnopqrstuvwxyz";
		char[] rands = new char[4];
		Random random = new Random();
		for(int i=0;i<4;i++) {
			rands[i] = str.charAt(random.nextInt(36));
		}
		return new String(rands);
	}
	/**
	 * 产生背景
	 * @param graphic
	 */
	private void drawBg(Graphics graphic) {
		graphic.setColor(new Color(0xDCDCDC));
		graphic.fillRect(0, 0, length, width);
		for(int i=0;i<100;i++) {
			int x = (int)Math.random()*length;
			int y = (int)Math.random()*width;
			int red = (int) (Math.random() * 255);  
            int green = (int) (Math.random() * 255);  
            int blue = (int) (Math.random() * 255);  
            graphic.setColor(new Color(red, green, blue));  
            graphic.drawOval(x, y, 1, 0);  
		}
	}
	
	private void drawPicture(Graphics graphic,String rands) {
		graphic.setColor(Color.BLACK);
		graphic.setFont(new Font(null,Font.BOLD|Font.ITALIC,18));
		 // 在不同的高度上输出验证码的每个字符  
		graphic.drawString("" + rands.charAt(0), 1, 17);  
		graphic.drawString("" + rands.charAt(1), 16, 15);  
		graphic.drawString("" + rands.charAt(2), 31, 18);  
		graphic.drawString("" + rands.charAt(3), 46, 16);  
	}
	
	public String draw() throws IOException {
		HttpServletResponse response = ServletActionContext.getResponse();  
        // 设置浏览器不要缓存此图片 
        response.setHeader("Pragma", "no-cache");  
        response.setHeader("Cache-Control", "no-cache");  
        response.setDateHeader("Expires", 0);  
        String rands = createRandom();  
        BufferedImage image = new BufferedImage(length, width,  
                 BufferedImage.TYPE_INT_RGB);  
        Graphics g = image.getGraphics();  
        // 产生图像  
        drawBg(g);  
        drawPicture(g, rands);  
        // 结束图像 的绘制 过程， 完成图像  
        g.dispose();  
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();  
        ImageIO.write(image, "jpeg", outputStream);  
        ByteArrayInputStream input = new ByteArrayInputStream(outputStream  
                 .toByteArray());  
        this.setInputStream(input);
        checkCode = rands;
        input.close();    
        outputStream.close();  
        return super.SUCCESS;
	}
	
	/**
	 * 添加ajax实时判断验证码是否正确
	 */
	public void executeAjax() {
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		ServletActionContext.getResponse().setContentType("text/html");
		String checkCod = req.getParameter("checkCode");
		
		Map<String,String> map = new HashMap<String,String>();
		if(checkCod.toLowerCase().equals(checkCode.toLowerCase())) {
			map.put("info", "验证码输入正确!");
			map.put("flag", "true");
			System.out.println("验证码输入正确");
		}else {
			map.put("info", "验证码输入错误!");
			map.put("flag", "false");
			System.out.println("验证码输入错误!");
		}
		JSONObject json = new JSONObject(map);
		try {
			ServletActionContext.getResponse().getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
