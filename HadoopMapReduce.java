/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseasedisgnosis;


import java.io.IOException;

import java.util.*;
//import org.apache.hadoop.fs.Path;
//import org.apache.hadoop.io.*;
//import org.apache.hadoop.mapred.*;
public class HadoopMapReduce{
//    public static class Map extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable>;
//        private final static IntWritable one =  new IntWritable(1);
//        private Text word = new Text();
     /*
        public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter) throws IOException{
                String line = value.toString();
                StringTokenizer tokenizer = new StringTokenizer(line);
                while(tokenizer.hasMoreTokens()){
                    word.set(tokenizer.nextToken());
                    output.collect(word, one);
                }
        }
    }
    public static class Reduce extends MapReduceBase implements Reducer<Text, IntWritable, Text, IntWritable>{
        public void reduce(Text key, Iterator<IntWritable> values,
            OutputCollector<Text, IntWritable> output, Reporter reporter)
            throws IOException{
                int sum = 0;
                while (values.hasNext()){
                    sum += values.next().get();
                }
                output.collect(key, new IntWritable(sum));
        }
    }
    public static void main(String[]args) throws IOException{
        JobConf conf = new JobConf(HadoopMapReduce.class);
        conf.setJobName(&quot;wordcount&quot;);
        conf.setOutputKeyClass(Text.class);
                conf.setOutputValueClass(IntWritable.class);
        conf.setMapperClass(Map.class);
        conf.setReducerClass(Reduce.class);
        conf.setInputFormat(TextInputFormat.class);
        conf.setOutputFormat(TextOutputFormat.class);
        FileInputFormat.setInputPaths(conf, new Path(args[0]));
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));
                try{
                    JobClient.runJob(conf);
                }catch(IOException e){
                    System.err.println(e.getMessage());
                }
    }
        */
}
