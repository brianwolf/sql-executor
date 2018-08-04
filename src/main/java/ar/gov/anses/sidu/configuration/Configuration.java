package ar.gov.anses.sidu.configuration;

import ar.gov.anses.sidu.configuration.Configuration;

public class Configuration {
	private static Configuration instance = null;

	private Configuration() {
	}

	public static Configuration getInstance() {
		if (instance == null) {
			synchronized (Configuration.class) {
				if (instance == null) {
					instance = new Configuration();
				}
			}
		}
		return instance;
	}
	
	
	private String redisUrl;
	private int redisPort;
	private int processNumberExpediente;
	private int threadPoolSize;
	private String queueExpedienteName;

	
	public String getRedisUrl() {
		return redisUrl;
	}

	public void setRedisUrl(String redisUrl) {
		this.redisUrl = redisUrl;
	}

	public int getRedisPort() {
		return redisPort;
	}

	public void setRedisPort(int redisPort) {
		this.redisPort = redisPort;
	}

	public int getProcessNumberExpediente() {
		return processNumberExpediente;
	}

	public void setProcessNumberExpediente(int processNumberExpediente) {
		this.processNumberExpediente = processNumberExpediente;
	}

	public int getThreadPoolSize() {
		return threadPoolSize;
	}

	public void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}

	public String getQueueExpedienteName() {
		return queueExpedienteName;
	}

	public void setQueueExpedienteName(String queueExpedienteName) {
		this.queueExpedienteName = queueExpedienteName;
	}

	
	
}
