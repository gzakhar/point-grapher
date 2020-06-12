package pack.modal;

import javax.persistence.*;

@Entity
@Table(name = "points")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int x;
	private int y;

	public Point() {
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getId() {
		return id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Point{" + "id=" + id + ", x=" + x + ", y=" + y + '}';
	}

}
