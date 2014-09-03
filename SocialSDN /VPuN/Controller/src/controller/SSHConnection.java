package controller;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.io.*;

public class SSHConnection {
  private int port =22;
  private String password="bismark123";
  private String host="192.168.142.1";
  private String user="root";
  
  public void establishConnection(){
	  try
      {
      JSch jsch = new JSch();
      Session session = jsch.getSession(user, host, port);
          session.setPassword(password);
          session.setConfig("StrictHostKeyChecking", "no");
      System.out.println("Establishing Connection...");
      session.connect();
      System.out.println("Connection established.");
      String command = "ls -l";
      
      Channel channel=session.openChannel("exec");
      ((ChannelExec)channel).setCommand(command);
      
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
          break;
        }
        try{Thread.sleep(1000);}catch(Exception ee){}
      }
      channel.disconnect();
      session.disconnect();
          
      }
  catch(Exception e){System.err.print(e);}
  }
  
	
	
}
