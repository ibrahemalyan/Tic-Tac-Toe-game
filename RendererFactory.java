public class RendererFactory {
    /**
     * function that return renderer according to it's given type
     * @param type
     * @param size
     * @return
     */
    public Renderer buildRenderer(String type, int size) {
        switch (type) {
            case "none":
                return new VoidRenderer();
            case "console":
                return new ConsoleRenderer(size);
            default:
                return null;
        }
    }

}
