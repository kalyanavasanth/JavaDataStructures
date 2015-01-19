package Threads;
/**
 * @author SESA366034
 *
 */
public class Packet {
	private static int id = 0;        //ID of a packet is incremented. Hence it is declared as static

	public Packet() {
		Packet.setId(Packet.getId() + 1);    //ID of packet is incremented
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Packet.id = id;
	}
}
