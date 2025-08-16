            //package com.zawadig.myafwanii.Config;
            //
            //import org.springframework.beans.factory.annotation.Value;
            //import org.springframework.context.annotation.Configuration;
            //import org.springframework.web.servlet.config.annotation.CorsRegistry;
            //import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
            //import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
            //
            //@Configuration
            //public class WebConfig implements WebMvcConfigurer {
            //
            //    // Directory for file uploads (default: ~/afwanii-uploads)
            //    @Value("${app.upload.dir:${user.home}/afwanii-uploads}")
            //    private String uploadDir;
            //
            //    @Override
            //    public void addCorsMappings(CorsRegistry registry) {
            //        registry.addMapping("/**")
            //                .allowedOriginPatterns(
            //                        "http://localhost:3000",         // React Web App
            //                        "http://localhost:19006",        // Expo Go (Dev Mode)
            //                        "http://10.8.11.84:19006",       // Mobile device (LAN)
            //                        "http://10.8.11.84:8081",        // Another local service
            //                        "http://localhost:62654"         // ThunderClient or Browser Test
            //                )
            //                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            //                .allowedHeaders("*")
            //                .allowCredentials(true)
            //                .maxAge(3600); // 1 hour cache for pre-flight requests
            //    }
            //
            //    @Override
            //    public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //        // Serving uploaded files
            //        registry.addResourceHandler("/uploads/**")
            //                .addResourceLocations("file:" + uploadDir + "/");
            //
            //        // Optional: Serve static frontend files (if any)
            //        registry.addResourceHandler("/static/**")
            //                .addResourceLocations("classpath:/static/");
            //    }
            //}
            package com.zawadig.myafwanii.Config;

            import org.springframework.beans.factory.annotation.Value;
            import org.springframework.context.annotation.Configuration;
            import org.springframework.web.servlet.config.annotation.CorsRegistry;
            import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
            //import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
            //
            //import java.nio.file.Paths;
            //
            //@Configuration
            //public class WebConfig implements WebMvcConfigurer {
            //
            //    // Directory for file uploads, fallback to ~/afwanii-uploads if not set
            //    @Value("${app.upload.dir:${user.home}/afwanii-uploads}")
            //    private String uploadDir;
            //
            //    @Override
            //    public void addCorsMappings(CorsRegistry registry) {
            //        registry.addMapping("/**")
            //                .allowedOriginPatterns(
            //                        "http://localhost:3000",         // React Web App
            //                        "http://localhost:19006",        // Expo Go (Dev Mode)
            //                        "http://10.8.11.37.63:19006",       // Mobile device (LAN)
            //                        "http://10.8.11.37:8081",        // Another local service
            //                        "http://localhost:62654"         // ThunderClient or Browser Test
            //                )
            //                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            //                .allowedHeaders("*")
            //                .allowCredentials(true)
            //                .maxAge(3600);
            //    }
            //
            //    @Override
            //    public void addResourceHandlers(ResourceHandlerRegistry registry) {
            //        // Normalize the upload directory path
            //        String normalizedUploadPath = Paths.get(uploadDir).toAbsolutePath().toUri().toString();
            //
            //        // Serve uploaded images at /uploads/**
            //        registry.addResourceHandler("/uploads/**")
            //                .addResourceLocations(normalizedUploadPath);
            //
            //        // (Optional) Serve static frontend files from /static/**
            //        registry.addResourceHandler("/static/**")
            //                .addResourceLocations("classpath:/static/");
            //    }
            //}
            import org.springframework.beans.factory.annotation.Value;
            import org.springframework.context.annotation.Configuration;
            import org.springframework.web.servlet.config.annotation.CorsRegistry;
            import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
            import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

            import java.nio.file.Paths;

            @Configuration
            public class WebConfig implements WebMvcConfigurer {

                @Value("${app.upload.dir:${user.home}/afwanii-uploads}")
                private String uploadDir;

                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/**")
                            .allowedOriginPatterns(
                                    "http://localhost:3000",
                                    "http://localhost:19006",
                                    "http://192.168.137.33:19006",
                                    "http://192.168.137.33:8081",
                                    "http://192.168.137.33:62654"
                            )
                            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                            .allowedHeaders("*")
                            .allowCredentials(false)
                            .maxAge(3600);
                }

                @Override
                public void addResourceHandlers(ResourceHandlerRegistry registry) {
                    registry.addResourceHandler("/api/images/**")
                            .addResourceLocations("file:" + Paths.get(uploadDir).toAbsolutePath().toString() + "/");
                }
            }
