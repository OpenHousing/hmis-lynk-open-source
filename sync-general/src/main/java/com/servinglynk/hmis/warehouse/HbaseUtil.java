package com.servinglynk.hmis.warehouse;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HBaseAdmin;

/**
 * Created by sandeep
 */
public class HbaseUtil {

    private static Configuration conf = null;

    public static HBaseAdmin getAdmin() throws Exception {
        conf = getConfiguration();
        HBaseAdmin admin = new HBaseAdmin(conf);
        return admin;
    }

    public static Configuration getConfiguration()
    {
        if(conf == null)
        {
            conf = HBaseConfiguration.create();
            conf.set("hbase.master", "ec2-52-25-176-93.us-west-2.compute.amazonaws.com");
            conf.set("hbase.zookeeper.quorum", "ec2-52-25-176-93.us-west-2.compute.amazonaws.com");
            conf.set("hbase.zookeeper.property.clientPort", "2181");
        }
        return conf;
    }


}
