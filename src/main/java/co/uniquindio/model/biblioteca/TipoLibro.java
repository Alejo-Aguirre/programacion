package co.uniquindio.model.biblioteca;

public enum TipoLibro {

        NOVELA(0), TEATRO(1), POESIA(2), ENSAYO(3);


	private int codigo ;

	/**
	 * @param codigoDoc
	 */
	private TipoLibro(int codigoDoc) {
		this.codigo = codigoDoc;
	}



	public TipoLibro getTipoDocumento (int index)
	{
		switch (index)
		{
		    case 0 : return TipoLibro.NOVELA;

		    case 1 : return TipoLibro.TEATRO;

		    case 2 : return TipoLibro.POESIA;

		    case 3 : return TipoLibro.ENSAYO;

		    default : return null;
		}
	}
}

