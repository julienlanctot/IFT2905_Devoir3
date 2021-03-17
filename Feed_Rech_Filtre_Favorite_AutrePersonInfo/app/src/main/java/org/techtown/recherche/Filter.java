//Filtre

package org.techtown.recherche;

public class Filter {

    String filterName;

    public Filter(String filterName) {
        this.filterName = filterName;
    }

    public String getFilterName() {
        return filterName;
    }

    public void setFilterName(String filterName) {
        this.filterName = filterName;
    }
}
