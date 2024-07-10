package com.apartmentFinder.ApartmentList.components;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;

public class ApartmentTestCard {
    public static void main(String[] args) {
        new ApartmentTestCard();
    }

    public ApartmentTestCard() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        private JLabel label;

        public TestPane() {
            setBorder(new EmptyBorder(16, 16, 16, 16));
            label = new JLabel("Nothing happening here, just waiting for stuff");
            setLayout(new GridBagLayout());
            add(label);

            startNextWorker();
        }

        protected void startNextWorker() {
            ExecutorWorker worker = new ExecutorWorker(new ExecutorWorker.Observer() {
                @Override
                public void workerDidUpdate(String message) {
                    label.setText(message);
                }
            });
            worker.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    if (worker.getState() == SwingWorker.StateValue.DONE) {
                        worker.removePropertyChangeListener(this);
                        startNextWorker();
                    }
                }
            });
            service.schedule(worker, 1500, TimeUnit.MILLISECONDS);
        }

    }

    public class ExecutorWorker extends SwingWorker<Void, String> {

        public interface Observer {
            public void workerDidUpdate(String message);
        }

        private Random rnd = new Random();
        private Observer observer;

        public ExecutorWorker(Observer observer) {
            this.observer = observer;
        }

        @Override
        protected Void doInBackground() throws Exception {
            publish("Starting some new work, back in a seocnd");
            Thread.sleep(1000 + rnd.nextInt(5000));
            publish("All the work is now done");
            return null;
        }

        @Override
        protected void process(List<String> chunks) {
            for (String messages : chunks) {
                observer.workerDidUpdate(messages);
            }
        }

    }
}