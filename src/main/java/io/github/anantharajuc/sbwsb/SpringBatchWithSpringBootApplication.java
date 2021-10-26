package io.github.anantharajuc.sbwsb;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lombok.extern.log4j.Log4j2;

@Log4j2
@EnableBatchProcessing
@SpringBootApplication
public class SpringBatchWithSpringBootApplication 
{
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step packageItemStep() 
	{
		return this.stepBuilderFactory.get("packageItemStep").tasklet(new Tasklet() 
		{
			public RepeatStatus execute(StepContribution arg0, ChunkContext arg1) throws Exception 
			{
				log.info("The item has been packaged.");
				
				return RepeatStatus.FINISHED;
			}
		}).build();
	}
	
	@Bean
	public Job deliverPackageJob()
	{
		return this.jobBuilderFactory.get("deliverPackageJob").start(packageItemStep()).build();
	}

	public static void main(String[] args) 
	{
		SpringApplication.run(SpringBatchWithSpringBootApplication.class, args);
	}
}