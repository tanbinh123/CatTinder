package fi.taponen.cattinder;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	//	Path imgUploadDir = Paths.get("./src/main/resources/static/images/cat-images");
		Path imgUploadDir = Paths.get("./cat-images");
		String imgUploadPath = imgUploadDir.toFile().getAbsolutePath();
		System.out.println(imgUploadPath);
		
		registry.addResourceHandler("/cat-images/**").addResourceLocations("file:/" + imgUploadPath + "/");
	}
}

