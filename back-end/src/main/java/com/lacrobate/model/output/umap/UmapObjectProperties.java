package com.lacrobate.model.output.umap;

public class UmapObjectProperties {
        public boolean easing;
        public boolean embedControl;
        public boolean fullscreenControl;
        public boolean searchControl;
        public boolean datalayersControl;
        public boolean zoomControl;
        public EmptyObject slideshow;
        public boolean captionBar;
        public EmptyObject limitBounds;
        public EmptyObject tilelayer;
        public String licence;
        public String description;
        public String name;
        public boolean displayPopupFooter;
        public boolean miniMap;
        public boolean moreControl;
        public boolean scaleControl;
        public boolean scrollWheelZoom;
        public int zoom;

        public UmapObjectProperties() {
                this.easing =  true;
                this.embedControl =  true;
                this.fullscreenControl =  true;
                this.searchControl =  true;
                this.datalayersControl =  true;
                this.zoomControl =  true;
                this.slideshow = new EmptyObject();
                this.captionBar =  false;
                this.limitBounds = new EmptyObject();
                this.tilelayer = new EmptyObject();
                this.licence =  "";
                this.description =  "";
                this.name =  "capteurs_par_site";
                this.displayPopupFooter =  false;
                this.miniMap =  false;
                this.moreControl =  true;
                this.scaleControl =  true;
                this.scrollWheelZoom =  true;
                this.zoom =  7;
        }
}
