package tests;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.*;

public class SSHConnection {
  private int port =22;
  private String password="bismark123";
  private String host="192.168.142.1";
  private String user="root";

  
  public SSHConnection(){
	  try
      {
      JSch jsch = new JSch();
      Session session = jsch.getSession(user, host, port);
          session.setPassword(password);
          session.setConfig("StrictHostKeyChecking", "no");
      session.connect();
      String command1 = "export PATH=/bin:/sbin:/usr/bin:/usr/sbin";
      String command2 = "echo $PATH";
   
      
      Channel channel=session.openChannel("exec");
      ((ChannelExec)channel).setCommand(command1 +" && "+ command2);
      
      
      channel.setInputStream(null);
      
      ((ChannelExec)channel).setErrStream(System.err);
      
      InputStream in=channel.getInputStream();
 
      channel.connect();
      
      byte[] tmp=new byte[2048];
      while(true){
        while(in.available()>0){
          int i=in.read(tmp, 0, 2048);
          if(i<0)break;
          System.out.print(new String(tmp, 0, i));
        }
        if(channel.isClosed()){
          System.out.println("exit-status: "+channel.getExitStatus());
          break;
        }
        try{Thread.sleep(1000);}catch(Exception ee){}
      }
      channel.disconnect();
      session.disconnect();
          
      }
  catch(Exception e){System.err.print(e);}
  }
  
  
  
  public int grantAccess(int speedLimit){
	  int channelS =0;
	  try
      {
      JSch jsch = new JSch();
      Session session = jsch.getSession(user, host, port);
          session.setPassword(password);
          session.setConfig("StrictHostKeyChecking", "no");
   
      session.connect();
      String command1 = "export PATH=/bin:/sbin:/usr/bin:/usr/sbin";
      String command2 = "tc qdisc replace dev wlan0 root tbf rate "+speedLimit+"kbit burst 20kb latency 10ms";
     //String command = "export PATH=/bin:/sbin:/usr/bin:/usr/sbin";
      Channel channel=session.openChannel("exec");
      ((ChannelExec)channel).setCommand(command1 + " && "+command2);
      
      channel.setInputStream(null);
      
      ((ChannelExec)channel).setErrStream(System.err);
      
      InputStream in=channel.getInputStream();
 
      channel.connect();
      
      byte[] tmp=new byte[1024];
      while(true){
        while(in.available()>0){
          int i=in.read(tmp, 0, 1024);
          if(i<0)break;
          System.out.print(new String(tmp, 0, i));
        }
        if(channel.isClosed()){
          System.out.println("exit-status: "+channel.getExitStatus());
           channelS =  channel.getExitStatus();
           break;
        }
        try{Thread.sleep(1000);}catch(Exception ee){}
      }
      channel.disconnect();
      session.disconnect();
      return channelS;
      }
  catch(Exception e){System.err.print(e);}
	  return -1;
  }
  
  
}
