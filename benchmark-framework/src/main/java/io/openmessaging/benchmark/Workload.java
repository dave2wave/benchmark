/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.openmessaging.benchmark;

import io.openmessaging.benchmark.utils.distributor.KeyDistributorType;

public class Workload {
    public String name;

    /** Number of topics to create in the test */
    public int topics;

    /** Number of partitions each topic will contain */
    public int partitionsPerTopic;

    public KeyDistributorType keyDistributor = KeyDistributorType.NO_KEY;

    public int messageSize;

    public boolean useRandomizedPayloads;
    public double randomBytesRatio;
    public int randomizedPayloadPoolSize;

    public String payloadFile;

    public int subscriptionsPerTopic;

    public int producersPerTopic;

    public int consumerPerSubscription;

    public int producerRate;
    /**
     * If the producerRate = 0, the generator will slowly grow producerRate to find the maximum balanced rate
     * This starts at 10000. Add an optional parameter to start the value closer to the balanced rate
     * The rates we are attempting may require an acceptable backlog on the order of 0.5 seconds of production
     * So, we also provide a way to set that value
     */
    public int producerStartRate = 10000;

    public int acceptableBacklog = 10000;

    /**
     * If the consumer backlog is > 0, the generator will accumulate messages until the requested amount of storage is
     * retained and then it will start the consumers to drain it.
     *
     * The testDurationMinutes will be overruled to allow the test to complete when the consumer has drained all the
     * backlog and it's on par with the producer
     */
    public long consumerBacklogSizeGB = 0;

    public long producerPauseBeforeDrain = 0;
    
    public int testDurationMinutes;
}
