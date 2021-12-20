public_key_path = "~/.ssh/kafka_aws.pub"
region          = "us-west-2"
az              = "us-west-2a"
ami             = "ami-9fa343e7" // RHEL-7.4

instance_types = {
  "kafka"     = "i3.4xlarge"
  "zookeeper" = "t3.small"
  "client"    = "c5.4xlarge"
}

num_instances = {
  "client"    = 11
  "kafka"     = 4
  "zookeeper" = 3
}
