package app;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.awt.image.BufferedImage;

public class ImageStack {
	private ArrayList<BufferedImage> imageStack; 
	private Boolean wasPopLast;
	
	public ImageStack() {
		imageStack = new ArrayList<BufferedImage>();
		wasPopLast = false;
	}
	
	public void push(BufferedImage dataItem) {
		imageStack.add(dataItem);
		wasPopLast = false;
	}
	
	public BufferedImage pop() throws EmptyStackException {
		if (imageStack.isEmpty()) {
			throw new EmptyStackException();
		} else {
			BufferedImage topImage = imageStack.remove(imageStack.size() - 1);
			wasPopLast = true;
			return topImage;			
		}
	}
	
	public BufferedImage peek() throws EmptyStackException {
		if (imageStack.isEmpty()) {
			throw new EmptyStackException();
		} else {
			return imageStack.get(imageStack.size() - 1);
			
		}
	}
	
	public boolean isEmpty() {
		return imageStack.isEmpty();
	}
	
	public void clear() {
		imageStack.clear();
	}
	
	public Boolean popWasLast() {
		return wasPopLast;
	}
	
	public int getSize() {
		return imageStack.size();
	}
}
