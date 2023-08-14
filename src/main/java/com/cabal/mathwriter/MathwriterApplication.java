package com.cabal.mathwriter;

import com.cabal.mathwriter.pojo.MathJob;
import com.cabal.mathwriter.service.ProblemGeneratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@Slf4j
@SpringBootApplication
public class MathwriterApplication implements CommandLineRunner {

    private ProblemGeneratorService problemGeneratorService = new ProblemGeneratorService();

    public static void main(String[] args) {
        log.info("STARTING THE APPLICATION");
        SpringApplication.run(MathwriterApplication.class, args);
        log.info("APPLICATION FINISHED");
    }

    @Override
    public void run(String... args) {
        log.info("EXECUTING : command line runner");
        Scanner in = new Scanner(System.in);
        String out = in.next();
        log.info("hello {}", out);

        MathJob mj = new MathJob();

        log.info("What grade level? ");
        mj.setGradeLevel(in.next());
        log.info("Make a comma delimited list of operators i.e +,-,* for adding, subtractin and multiplying");
        mj.setOperators(in.next());
        log.info("What Is the title? ");
        mj.setTitle(in.next());

        log.info("MATH BOOK WRITING FOR {}", mj);

        problemGeneratorService.makeMathBook(mj);

        for (int i = 0; i < args.length; ++i) {
            log.info("args[{}]: {}", i, args[i]);
        }
    }

   /* public static void main(String[] args) {
        SpringApplication.run(MathwriterApplication.class, args);
    }
*/
}
