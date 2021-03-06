/*
 * Copyright 2015 Timothy Brooks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package net.uncontended.precipice_implementations.kafka;

public class KafkaService<K, V> {

//    private final Producer<K, V> producer;
//
//    public KafkaService(String name, ServiceProperties properties, Producer<K, V> producer) {
//        super(name, properties.circuitBreaker(), properties.actionMetrics(), properties.latencyMetrics(),
//                properties.semaphore());
//        this.producer = producer;
//    }
//
//    public PrecipiceFuture<RecordMetadata> sendRecordAction(ProducerRecord<K, V> record) {
//        KafkaAction<RecordMetadata, K, V> action = new RecordMetadataAction<>(record);
//        return submit(action, -1);
//    }
//
//    @Override
//    public <T> PrecipiceFuture<T> submit(ResilientAction<T> action, long millisTimeout) {
//        final Eventual<T> eventual = new Eventual<>();
//        complete(action, eventual, millisTimeout);
//        return eventual;
//    }
//
//    @Override
//    public <T> void complete(ResilientAction<T> action, final PrecipicePromise<T> promise, long millisTimeout) {
//        acquirePermitOrRejectIfActionNotAllowed();
//
//        final KafkaAction<T, K, V> kafkaAction = (KafkaAction<T, K, V>) action;
//        long startTime = System.nanoTime();
//        try {
//            producer.send(kafkaAction.getRecord(), new CompletingCallback<>(startTime, actionMetrics, latencyMetrics,
//                    semaphore, promise, kafkaAction));
//        } catch (Exception e) {
//            // Do not record latency due to fail fast.
//            actionMetrics.incrementMetricCount(Metric.ERROR);
//            promise.completeExceptionally(e);
//        }
//    }
//
//    @Override
//    public void shutdown() {
//        isShutdown = true;
//        producer.close();
//    }
//
//    private static class CompletingCallback<T> implements Callback {
//        private final long startTime;
//        private final ActionMetrics actionMetrics;
//        private final LatencyMetrics latencyMetrics;
//        private final PrecipiceSemaphore semaphore;
//        private final PrecipicePromise<T> promise;
//        private final KafkaAction<T, ?, ?> kafkaAction;
//
//        public CompletingCallback(long startTime, ActionMetrics actionMetrics, LatencyMetrics latencyMetrics,
//                                  PrecipiceSemaphore semaphore, PrecipicePromise<T> promise,
//                                  KafkaAction<T, ?, ?> kafkaAction) {
//            this.startTime = startTime;
//            this.actionMetrics = actionMetrics;
//            this.latencyMetrics = latencyMetrics;
//            this.semaphore = semaphore;
//            this.promise = promise;
//            this.kafkaAction = kafkaAction;
//        }
//
//        @Override
//        public void onCompletion(RecordMetadata metadata, Exception exception) {
//            try {
//                handleResult(startTime, promise, kafkaAction, metadata, exception);
//            } finally {
//                semaphore.releasePermit();
//            }
//        }
//
//        private void handleResult(long startTime, PrecipicePromise<T> promise, KafkaAction<T, ?, ?> kafkaAction,
//                                  RecordMetadata metadata, Exception exception) {
//            if (exception == null) {
//                kafkaAction.setRecordMetadata(metadata);
//
//                try {
//                    T result = kafkaAction.run();
//                    long endTime = System.nanoTime();
//                    actionMetrics.incrementMetricCount(Metric.SUCCESS, endTime);
//                    latencyMetrics.recordLatency(Metric.SUCCESS, endTime - startTime, endTime);
//                    promise.complete(result);
//                } catch (ActionTimeoutException e) {
//                    long endTime = System.nanoTime();
//                    actionMetrics.incrementMetricCount(Metric.TIMEOUT, endTime);
//                    latencyMetrics.recordLatency(Metric.TIMEOUT, endTime - startTime, endTime);
//                    promise.completeWithTimeout(e);
//                } catch (Exception e) {
//                    long endTime = System.nanoTime();
//                    actionMetrics.incrementMetricCount(Metric.ERROR, endTime);
//                    latencyMetrics.recordLatency(Metric.ERROR, endTime - startTime, endTime);
//                    promise.completeExceptionally(e);
//                }
//            } else {
//                long endTime = System.nanoTime();
//                if (exception instanceof TimeoutException) {
//                    actionMetrics.incrementMetricCount(Metric.TIMEOUT, endTime);
//                    latencyMetrics.recordLatency(Metric.TIMEOUT, endTime - startTime, endTime);
//                    promise.completeWithTimeout(new ActionTimeoutException(exception));
//                } else {
//                    actionMetrics.incrementMetricCount(Metric.ERROR, endTime);
//                    latencyMetrics.recordLatency(Metric.ERROR, endTime - startTime, endTime);
//                    promise.completeExceptionally(exception);
//                }
//            }
//        }
//    }
//
//    private static class RecordMetadataAction<K, V> extends KafkaAction<RecordMetadata, K, V> {
//        public RecordMetadataAction(ProducerRecord<K, V> record) {
//            super(record);
//        }
//
//        @Override
//        public RecordMetadata run() throws Exception {
//            return recordMetadata;
//        }
//    }
}
