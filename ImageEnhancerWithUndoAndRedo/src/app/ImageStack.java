package app;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageStack {
	private ArrayList<BufferedImage> imageStack; 
	private BufferedImage dataItem;
	private Boolean wasPopLast;
	
	public ImageStack() {
		imageStack = new ArrayList<BufferedImage>();
		wasPopLast = false;
	}
	
	private void push(BufferedImage dataItem) {
		imageStack.add(dataItem);
		wasPopLast = false;
	}
	
	private BufferedImage pop() throws Exception {
		try {
			BufferedImage topImage = imageStack.remove(imageStack.size() - 1);
			wasPopLast = true;
			return topImage;
		} catch(Exception stackIsEmpty) {
			return null;
		}
	}
	
	private BufferedImage peek() throws Exception{
		try {
			return imageStack.get(imageStack.size() - 1);
		} catch(Exception stackIsEmpty) {
			return null;
		}
	}
	
	private boolean isEmpty() {
		return imageStack.isEmpty();
	}
	
	private void clear() {
		imageStack.clear();
	}
	
	private Boolean popWasLast() {
		return wasPopLast;
	}
	
	private int getSize() {
		return imageStack.size();
	}
}
