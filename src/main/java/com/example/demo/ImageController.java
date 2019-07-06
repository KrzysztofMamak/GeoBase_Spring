package com.example.demo;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
public class ImageController {
	@RequestMapping(value="/{number}", method=RequestMethod.GET, produces="image/jpg")
	public @ResponseBody byte[] getFile(@PathVariable int number) {
		try {
			InputStream is = this.getClass().getResourceAsStream("/" + number + ".jpg");
			BufferedImage image = ImageIO.read(is);
			ByteArrayOutputStream bao = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", bao);
			
			return bao.toByteArray();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
