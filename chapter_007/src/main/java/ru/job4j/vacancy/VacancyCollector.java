package ru.job4j.vacancy;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main executable class to start sql.ru vacancy parser
 */
public class VacancyCollector {

    private static final Logger LOG = LoggerFactory.getLogger(VacancyCollector.class);

    public static void main(String[] args) {
        JobMainStarter jobMainStarter = new JobMainStarter(args);
        try {
            var message = jobMainStarter.start(VacancyCollectorJob.class);
            LOG.info(message);
        } catch (Exception e) {
            jobMainStarter.handleException(LOG, e);
            try {
                jobMainStarter.shutdown(false);
            } catch (SchedulerException ex) {
                // ignored
            }
        }
    }
}
