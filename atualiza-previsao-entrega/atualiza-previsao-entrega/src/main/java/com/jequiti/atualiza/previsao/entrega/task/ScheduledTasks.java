package com.jequiti.atualiza.previsao.entrega.task;


import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import com.jequiti.atualiza.previsao.entrega.config.RestTemplateConfig;
import com.jequiti.atualiza.previsao.entrega.controller.AtualizaPrevisaoEntregaController;

@Service
@Component
@ContextConfiguration(classes = { RestTemplateConfig.class })
public class ScheduledTasks implements SchedulingConfigurer, Serializable {

	private static final long serialVersionUID = -24988274869270001L;
	/*TaskScheduler taskScheduler;
	private ScheduledFuture<?> jobAcaoAtualizar;

	private final AtualizaPrevisaoEntregaController _atualizaPrevisaoEntregaController;

	@Autowired
	public ScheduledTasks(AtualizaPrevisaoEntregaController _atualizaPrevisaoEntregaController) {
		this._atualizaPrevisaoEntregaController = _atualizaPrevisaoEntregaController;
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

		ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
		threadPoolTaskScheduler.setPoolSize(10);
		threadPoolTaskScheduler.setThreadNamePrefix("responsys-scheduler-thread");
		threadPoolTaskScheduler.initialize();

		
		jobAcaoAtualizar(threadPoolTaskScheduler);

		
		this.taskScheduler = threadPoolTaskScheduler;
		taskRegistrar.setScheduler(threadPoolTaskScheduler);
	}

	private void jobAcaoAtualizar(TaskScheduler scheduler) {
		setjobAcaoAtualizar(scheduler.schedule(() -> {
			try {
				this._atualizaPrevisaoEntregaController.atualizaNotasFiscaisSemPrevisaoEntrega();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, new Trigger() {

			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				String cronExp = "0/200 * * * * ?";
				return new CronTrigger(cronExp).nextExecutionTime(triggerContext);
			}
		}));
	}

	public ScheduledFuture<?> getjobAcaoAtualizar() {
		return jobAcaoAtualizar;
	}

	public void setjobAcaoAtualizar(ScheduledFuture<?> jobAcaoAtualizar) {
		this.jobAcaoAtualizar = jobAcaoAtualizar;
	}*/

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		// TODO Auto-generated method stub
		
	}
}