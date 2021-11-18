import ForceGraph from 'force-graph';

export default function GraphGenerator(payload) {
  const { data, width, height, container } = payload;
  const graph = ForceGraph()(container);
  graph
    .width(width)
    .height(height)
    .graphData(data)
    .nodeCanvasObject((node, canvasCtx) => {
      canvasCtx.beginPath();

      canvasCtx.fillStyle = node.url == null ? '#CEE7CC' : '#ffffff';
      canvasCtx.arc(node.x, node.y, 3, 0, 2 * Math.PI, false);
      canvasCtx.stroke();
      canvasCtx.lineWidth = 0.5;
      canvasCtx.fill();

      canvasCtx.fillStyle = 'black';
      canvasCtx.font = `3px 'Montserrat'`;
      canvasCtx.textAlign = 'center';
      canvasCtx.textBaseline = 'middle';
      canvasCtx.fillText(node.name, node.x, node.y + 6);
    })
    .dagMode('td')
    .dagLevelDistance(13)
    .linkDirectionalArrowLength(6)
    .linkDirectionalArrowRelPos(1)
    .zoom(5)
    .onNodeClick(({ url }) => url != null && window.open(url, '_blank'));
}
