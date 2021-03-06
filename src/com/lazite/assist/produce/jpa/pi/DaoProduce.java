package com.lazite.assist.produce.jpa.pi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.lazite.assist.file.FileUtils;
import com.lazite.assist.freemarker.FreeMarkers;
import com.lazite.assist.produce.Pi;
import com.lazite.assist.produce.jpa.pojo.FilePo;
import com.lazite.assist.produce.util.EntityEnums;

public class DaoProduce implements Pi{
	private FilePo filePo;
	
	
	public void produce() throws Exception {	
		String s=FreeMarkers.getFtlString(this.getResourceBufferedReader("/com/lazite/assist/produce/jpa/ftl/single/dao.ftl"),
				new String[]{"project","name"},
				new Object[]{this.filePo.getProjectName(),this.getFilePo().getClassName()});
		
				
		FileUtils.createFile(this.filePo.getPath(),this.filePo.getFilename(EntityEnums.Dao));
		FileUtils.writeFileContent(this.filePo.getPath()+this.filePo.getFilename(EntityEnums.Dao), s);
	}

	//"/resource/res.txt"===url 例
	public BufferedReader getResourceBufferedReader(String url) throws IOException{    
        //返回读取指定资源的输入流    
        InputStream is=this.getClass().getResourceAsStream(url);      
        BufferedReader br=new BufferedReader(new InputStreamReader(is));    
        return br;
    } 

	public FilePo getFilePo() {
		return filePo;
	}
	public void setFilePo(FilePo filePo) {
		this.filePo = filePo;
	}
	
}
