import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glEnd;

import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL11.*;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.GLU.*;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import org.newdawn.slick.Color;

import java.lang.System.*;
import org.lwjgl.input.*;

public class Font {
	final static int width = 800, height = 450;
	final static int frameRate = 90;
	boolean[] keys = new boolean[256];
	Texture blank, period, comma, a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;
	static String line0 = "                                                                                  ";
	static String line1 = " a long time ago, in a galaxy far far away there lived a boy named luke skywalker.";
	static String line2 = " and my name is ishmael. and i want to jam some more things in so hold on.        ";
	
	public static void main(String[] args) throws LWJGLException {
		float x_pos;
		float y_pos;
		x_pos = 0;
		y_pos = 0;
		Display.setDisplayMode(new DisplayMode(width,height));
		String title_value = "Font Test!";
		Display.setTitle(title_value);
		Display.create();
		Font font = new Font();
		while(!Display.isCloseRequested() &&
				!Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
			font.render();
			int[] x_y = font.move();
			y_pos -= x_y[1];
			x_pos -= x_y[0];
			GL11.glTranslatef(x_pos,y_pos,0);
			font.scenery();
			GL11.glLoadIdentity();
			font.hero();
			font.stringToCharacter(line0, 0);
			font.stringToCharacter(line1, 1);
			font.stringToCharacter(line2, 2);
			Display.update();
			Display.sync(frameRate);
		}
		Display.destroy();
		System.exit(0);
	}
	private void loadTextures(){
		try{
			blank = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("blank.png"));
			period = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("period.png"));
			comma = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("comma.png"));
			a = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("a.png"));
			b = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("b.png"));
			c = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("c.png"));
			d = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("d.png"));
			e = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("e.png"));
			f = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("f.png"));
			g = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("g.png"));
			h = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("h.png"));
			i = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("i.png"));
			j = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("j.png"));
			k = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("k.png"));
			l = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("l.png"));
			m = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("m.png"));
			n = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("n.png"));
			o = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("o.png"));
			p = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("p.png"));
			q = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("q.png"));
			r = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("r.png"));
			s = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("s.png"));
			t = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("t.png"));
			u = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("u.png"));
			v = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("v.png"));
			w = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("w.png"));
			x = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("x.png"));
			y = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("y.png"));
			z = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("z.png"));
			
		}catch(Exception e){
			System.err.println("Failed to load texture: ");
			e.printStackTrace();
		}
	}
	
	public Font(){
		loadTextures();
	}
	
	public int[] move(){
		Keyboard.enableRepeatEvents(true);
		while(Keyboard.next()){
			if(Keyboard.getEventKeyState()){
			if (Keyboard.isKeyDown(Keyboard.KEY_W)){
				int[] x_y = {0,10};
				return x_y;
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_S)){
				int[] x_y = {0,-10};
				return x_y;
			} 
			if (Keyboard.isKeyDown(Keyboard.KEY_A)){
				int[] x_y = {-10,0};
				return x_y;
			} 
			if (Keyboard.isKeyDown(Keyboard.KEY_D)){
				int[] x_y = {10,0};
				return x_y;
			}
			}
		}
		int[] x_y = {0,0};
		return x_y;
	}
	
	public void sword(){
		
	}
	
	public void render(){
		clearScreen();
		GL11.glViewport(0, 0, width, height);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0f, width, 0f, height,-1f,1f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		GL11.glLineWidth(1.0f);
	}
	
	public void hero(){
		GL11.glColor3f(1f, 1f, 1f);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(392, 217);
		GL11.glVertex2f(408, 217);
		GL11.glVertex2f(408, 241);
		GL11.glVertex2f(392, 241);
		GL11.glEnd();
	}
	
	public void scenery(){
		GL11.glColor3f(0f, 0f, 1f);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(-100, -200);
		GL11.glVertex2f(408 + 40, -200);
		GL11.glVertex2f(408 + 40, 500);
		GL11.glVertex2f(-100, 500);
		GL11.glEnd();
		
		GL11.glColor3f(0f, 1f, 0f);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glVertex2f(-100, 100);
		GL11.glVertex2f(408 + 40, 100);
		GL11.glVertex2f(408 + 40, 150);
		GL11.glVertex2f(-100, 150);
		GL11.glEnd();
	}
	
	public void stringToCharacter(String lineValue, float y_loc){
		String[] lineArray = lineValue.split("");
		int x = 1;
		while (x < lineArray.length){
			character(lineArray[x],8 + x, 8 - y_loc);
			x += 1;
		}
	}
	
	public void character(String strtexture, float x_loc, float y_loc){
		
		char chartexture = strtexture.charAt(0);
		
		if (chartexture == 'a'){
			a.bind();
		}
		else if (chartexture == 'b'){
			b.bind();
		}
		else if (chartexture == 'c'){
			c.bind();
		}
		else if (chartexture == 'd'){
			d.bind();
		}
		else if (chartexture == 'e'){
			e.bind();
		}
		else if (chartexture == 'f'){
			f.bind();
		}
		else if (chartexture == 'g'){
			g.bind();
		}
		else if (chartexture == 'h'){
			h.bind();
		}
		else if (chartexture == 'i'){
			i.bind();
		}
		else if (chartexture == 'j'){
			j.bind();
		}
		else if (chartexture == 'k'){
			k.bind();
		}
		else if (chartexture == 'l'){
			l.bind();
		}
		else if (chartexture == 'm'){
			m.bind();
		}
		else if (chartexture == 'n'){
			n.bind();
		}
		else if (chartexture == 'o'){
			o.bind();
		}
		else if (chartexture == 'p'){
			p.bind();
		}
		else if (chartexture == 'q'){
			q.bind();
		}
		else if (chartexture == 'r'){
			r.bind();
		}
		else if (chartexture == 's'){
			s.bind();
		}
		else if (chartexture == 't'){
			t.bind();
		}
		else if (chartexture == 'u'){
			u.bind();
		}
		else if (chartexture == 'v'){
			v.bind();
		}
		else if (chartexture == 'w'){
			w.bind();
		}
		else if (chartexture == 'x'){
			x.bind();
		}
		else if (chartexture == 'y'){
			y.bind();
		}
		else if (chartexture == 'z'){
			z.bind();
		}
		else if (chartexture == ' '){
			blank.bind();
		}
		else if (chartexture == '.'){
			period.bind();
		}
		else if (chartexture ==','){
			comma.bind();
		}
		else{
			System.out.println("Error");
		}
		GL11.glColor3f(1f, 1f, 1f);
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(0 + x_loc*8, 0 + y_loc*8);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(8 + x_loc*8, 0 + y_loc*8);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(8 + x_loc*8, 8 + y_loc*8);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(0 + x_loc*8, 8 + y_loc*8);
		GL11.glEnd();
		
	}
	public void clearScreen(){
		//Clear the screen
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glLoadIdentity();
	}
}
