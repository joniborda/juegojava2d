package graficos;

public class Sprite {
	public final int LADO;
	private int x;
	private int y;

	public int[] pixeles;
	private final HojaSprites hoja;

	// coleccion de sprites
	public static final Sprite ASFALTO = new Sprite(32, 0, 0, HojaSprites.desierto);

	public Sprite(int lado, final int columna, final int fila,
			final HojaSprites hoja) {
		this.LADO = lado;
		this.pixeles = new int[lado * lado];
		this.x = columna * lado;
		this.y = fila * lado;
		this.hoja = hoja;

		for (int y = 0; y < lado; y++) {
			for (int x = 0; x < lado; x++) {
				pixeles[x + y * lado] = hoja.pixeles[(x + this.x)
						+ (y + this.y) * hoja.obtenAncho()];
			}
		}
	}

}
