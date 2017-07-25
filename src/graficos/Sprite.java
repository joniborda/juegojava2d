package graficos;

public class Sprite {
	private final int LADO;
	private int x;
	private int y;

	public int[] pixeles;
	private HojaSprites hoja;

	// coleccion de sprites
	public static final Sprite VACIO = new Sprite(32, 0x000000);
	public static final Sprite ASFALTO = new Sprite(32, 0, 0,
			HojaSprites.desierto);
	public static final Sprite ARENA = new Sprite(32, 1, 0,
			HojaSprites.desierto);
	public static final Sprite BORDE_CARRETERA = new Sprite(32, 2, 0,
			HojaSprites.desierto);
	public static final Sprite CENTRO_CARRETERA = new Sprite(32, 3, 0,
			HojaSprites.desierto);
	public static final Sprite ESQUINA_CARRETERA = new Sprite(32, 4, 0,
			HojaSprites.desierto);
	public static final Sprite PARED_PIEDRA = new Sprite(32, 5, 0,
			HojaSprites.desierto);
	public static final Sprite PARED_PIEDRA_INFERIOR = new Sprite(32, 6, 0,
			HojaSprites.desierto);
	public static final Sprite PARED_PIEDRA_CARRETERA = new Sprite(32, 0, 3,
			HojaSprites.desierto);
	public static final Sprite PUERTA_SUPERIOR_IZQUIERDA = new Sprite(32, 7, 0,
			HojaSprites.desierto);
	public static final Sprite PUERTA_INTERMEDIA_IZQUIERDA = new Sprite(32, 7, 1,
			HojaSprites.desierto);
	public static final Sprite PUERTA_INFERIOR = new Sprite(32, 8, 1,
			HojaSprites.desierto);
	public static final Sprite OXIDO = new Sprite(32, 9, 0,
			HojaSprites.desierto);
	public static final Sprite PUERTA_SUPERIOR_CENTRAL = new Sprite(32, 8, 0,
			HojaSprites.desierto);

	public Sprite(final int lado, final int columna, final int fila,
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
	
	public Sprite(final int lado, final int color) {
		this.LADO = lado;
		pixeles = new int[lado*lado];
		
		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = color;
		}
	}
	
	public int obtenLado() {
		return LADO;
	}

}
