package app;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.awt.image.BufferedImage;

/**
 * ImageStack.java
 * by Ivy Wong for CSE 373 Assignment 1, Autumn 2014.
 * This is a program that stores the images edited in the Image Enhancer program.
 * The ImageStack objects are used in the program for storing the images to be
 * redo or undo.
 */

public class ImageStack {
	private ArrayList<BufferedImage> imageStack; // Stack that stores the images
	private Boolean wasPopLast;					 // Determines if the last action 
												 // was removing the top image in the ImageStack
	
	/**
	 * Constructs an empty ImageStack
	 * 
	 */
	public ImageStack() {
		imageStack = new ArrayList<BufferedImage>();
		wasPopLast = false;
	}
	
	/**
	 * Adds the given image to the ImageStack
	 * 
	 * @param dataItem The given BufferedImage 
	 */
	public void push(BufferedImage dataItem) {
		imageStack.add(dataItem);
		wasPopLast = false;
	}
	
	/**
	 * Removes and returns the top image in the ImageStack
	 * 
	 * @return topImage The image at the top of the ImageStack
	 * @throws EmptyStackException if the ImageStack is empty
	 */
	public BufferedImage pop() throws EmptyStackException {
		if (imageStack.isEmpty()) {
			throw new EmptyStackException();
		} else {
			BufferedImage topImage = imageStack.remove(imageStack.size() - 1);
			wasPopLast = true;
			return topImage;			
		}
	}
	
	/**
	 * Return what image is at the top of the ImageStack
	 * 
	 * @return topImage The image at the top of the ImageStack
	 * @throws EmptyStackException if the ImageStack is empty
	 */
	public BufferedImage peek() throws EmptyStackException {
		if (imageStack.isEmpty()) {
			throw new EmptyStackException();
		} else {
			BufferedImage topImage = imageStack.get(imageStack.size() - 1);
			return topImage;
		}
	}
	
	/** 
	 * Returns whether or not the ImageStack is empty
	 * 
	 * @return true If the ImageStack is empty
	 */
	public boolean isEmpty() {
		return imageStack.isEmpty();
	}
	
	/**
	 * Clears the ImageStack of all images
	 * 
	 */
	public void clear() {
		imageStack.clear();
		wasPopLast = false;
	}
	
	/**
	 * Returns whether or not the last action performed had removed the top
	 * image of the ImageStack
	 * 
	 * @return true If the last action performed had to remove the top image 
	 * in the ImageStack
	 */
	public Boolean popWasLast() {
		return wasPopLast;
	}
	
	/**
	 * Returns the number of images in the IamgeStack
	 * 
	 * @return size The number of images in the ImageStack
	 */
	public int getSize() {
		int size =imageStack.size();
		return size;
	}
}
