package klassen;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



public class FileMaker implements FileMakerInterface {
	public FileMaker() {}
	
	@Override
	public void slaMainOp(HoofdController a) throws IOException{
		ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("controller.obj"));
		try{
		oout.writeObject(a);
		}catch(NotSerializableException nse){
			
		}
		oout.close();
	}
	@Override
	public HoofdController openMain() throws IOException{
		ObjectInputStream oin = new ObjectInputStream(new FileInputStream("controller.obj"));
		Object o = null;
		HoofdController a = null;
		try {
			o = oin.readObject();
			if(o instanceof HoofdController){
				a = (HoofdController)o;
			}
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

		oin.close();
		return a;	
	}
}
