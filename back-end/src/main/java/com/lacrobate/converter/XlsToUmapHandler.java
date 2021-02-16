package com.lacrobate.converter;

import com.lacrobate.model.XLSRow;
import com.lacrobate.model.output.common.*;
import com.lacrobate.model.output.umap.Layer;
import com.lacrobate.model.output.umap.UmapObject;
import com.lacrobate.model.output.umap.UmapObjectProperties;
import com.lacrobate.model.output.umap.UmapOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class XlsToUmapHandler extends XLSHandler {
    private Logger log = LoggerFactory.getLogger(XlsToUmapHandler.class);

    public XlsToUmapHandler() {
        this.TARGET_FILE_EXTENSION = ".umap";
    }

    @Override
    protected UmapObject createResultObjectFrom(List<XLSRow> rowList) {
        UmapObject result = new UmapObject();

        preparerHeaders(result);
        Map<String, Layer> layerMap = createLayerMapFrom(rowList);

        result.setLayers(new ArrayList<>(layerMap.values()));
        log.info("json object construction finished: ");
        log.info(result.toString());

        return result;
    }

    private Map<String, Layer> createLayerMapFrom(List<XLSRow> rowList) {
        HashMap<String, Layer> layerMap = new HashMap<>();

        for (XLSRow row: rowList) {
            Feature feature = mapper.xlsRowToFeature(row);
            addFeatureToLayerMap(feature, layerMap);
        }

        addCountToLayerNames(layerMap);

        return layerMap;
    }

    /**
     * ajouter le nombre de features au nom du layer (exemple : 'layer_name' -> 'layer_name (19)')
     * ajouter une couleur random a chaque layer
     * @param layerMap
     */
    private void addCountToLayerNames(HashMap<String, Layer> layerMap) {
        for (Layer layer: layerMap.values()) {
            UmapOptions umap_options = layer.get_umap_options();

            String layerName = umap_options.getName();
            umap_options.setName(layerName + " (" + layer.getFeatures().size() + ")");

            umap_options.setColor(ColorEnum.getRandomColor());
            umap_options.setIconClass(IconClassEnum.getRandomIconClass());
        }
    }

    private void addFeatureToLayerMap(Feature feature, Map<String, Layer> layerMap) {
        String nomSite = feature.getProperties().getNom_site();
        Layer layer = layerMap.get(nomSite);
        if (layer == null) {
            layer = createLayer(nomSite);
            layerMap.put(nomSite, layer);
        }
        layer.getFeatures().add(feature);
    }

    private Layer createLayer(String nomSite) {
        Layer layer = new Layer();

        UmapOptions options = new UmapOptions();
        options.setName(nomSite);
        layer.set_umap_options(options);

        return layer;
    }

    /**
     * methode ajoutant les headers (type, properties, geometry...) à l'objet umap en parametre
     * @param result objet à enrichir
     */
    private void preparerHeaders(UmapObject result) {
        result.setGeometry(preparerGeometry());
        result.setProperties(new UmapObjectProperties());
    }

    private Geometry preparerGeometry() {
        Geometry geometry = new Geometry();

        geometry.setType(GeometryTypeEnum.Point.name());
        float[] coordinates = new float[2];
        coordinates[0] = 2.5927734375000004f;
        coordinates[1] = 49.97242235423708f;
        geometry.setCoordinates(coordinates);

        return geometry;
    }
}
