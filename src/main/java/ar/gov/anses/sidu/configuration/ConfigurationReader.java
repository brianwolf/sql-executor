package ar.gov.anses.sidu.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ConfigurationReader {

	private final String propFileName = "sidu-jlib.properties";

	private static final Logger LOGGER = Logger.getLogger("ar.gov.anses.sieel.jlib.configuration.ConfigurationReader");

	public boolean loadConfiguration() {
		String error = "Failed while reading parameter, using jlib.properties -> ";
		boolean result = true;
		try {
			LOGGER.log(Level.INFO, "Start reading configuration for jlib");
			Configuration conf = Configuration.getInstance();

			ConfigurationEntry processNumberExpediente = getConfigurationEntry("sieel-jlib.processNumberExpediente");
			ConfigurationEntry threadPoolSize = getConfigurationEntry("sieel-jlib.threadPoolSize");
			ConfigurationEntry queueExpedienteName = getConfigurationEntry("sieel-jlib.queueExpedienteName");
			
			if (processNumberExpediente.getParameterConfiguration() != null)
				conf.setProcessNumberExpediente(Integer.parseInt(processNumberExpediente.getParameterConfiguration()));
			else {
				conf.setProcessNumberExpediente(Integer.parseInt(processNumberExpediente.getFileConfiguration()));
				LOGGER.log(Level.WARNING, error + "sieel-jlib.processNumberExpediente");
			}
			
			if (threadPoolSize.getParameterConfiguration() != null)
				conf.setThreadPoolSize(Integer.parseInt(threadPoolSize.getParameterConfiguration()));
			else {
				conf.setThreadPoolSize(Integer.parseInt(threadPoolSize.getFileConfiguration()));
				LOGGER.log(Level.WARNING, error + "sieel-jlib.threadPoolSize");
			}
			
			if (queueExpedienteName.getParameterConfiguration() != null)
				conf.setQueueExpedienteName(queueExpedienteName.getParameterConfiguration());
			else {
				conf.setQueueExpedienteName(queueExpedienteName.getFileConfiguration());
				LOGGER.log(Level.WARNING, error + "sieel-jlib.queueExpedienteName");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, "Failed reading configuration");
			result = false;
		}
		return result;
	}

	private ConfigurationEntry getConfigurationEntry(String propertyName) {
		ConfigurationEntry result = null;
		InputStream inputStream = null;
		try {
			Properties prop = new Properties();
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
			if (inputStream != null) {
				prop.load(inputStream);
			}
			String parameterConfiguration = System.getProperty(propertyName);
			String fileConfiguration = prop.getProperty(propertyName);
			result = new ConfigurationEntry(parameterConfiguration, fileConfiguration);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

}
