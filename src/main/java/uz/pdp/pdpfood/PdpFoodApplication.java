package uz.pdp.pdpfood;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import uz.pdp.pdpfood.bot.PdpFoodBot;
import uz.pdp.pdpfood.service.user.UserService;

@EnableScheduling
@EnableSwagger2
@SpringBootApplication
@RequiredArgsConstructor
public class PdpFoodApplication {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PdpFoodApplication.class, args);
        PdpFoodBot telegramBotConfigurer = run.getBean(PdpFoodBot.class);
        telegramBotConfigurer.run();
    }


    @Scheduled(cron = "0 10 8-10 * * MON-FRI", zone = "Asia/Tashkent")
    public void scheduler() {
        System.out.println("Do you order for lunch?");
    }

}
