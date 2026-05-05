@Test
public void testVolume_LitreToMillilitre() {
    Quantity<VolumeUnit> v =
            new Quantity<>(1.0, VolumeUnit.LITRE);

    assertEquals(
            new Quantity<>(1000.0, VolumeUnit.MILLILITRE),
            v.convertTo(VolumeUnit.MILLILITRE)
    );
}

@Test
public void testVolume_Addition() {
    Quantity<VolumeUnit> v1 =
            new Quantity<>(1.0, VolumeUnit.LITRE);

    Quantity<VolumeUnit> v2 =
            new Quantity<>(1000.0, VolumeUnit.MILLILITRE);

    assertEquals(
            new Quantity<>(2.0, VolumeUnit.LITRE),
            v1.add(v2)
    );
}