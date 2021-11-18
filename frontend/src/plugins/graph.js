import ForceGraph from 'force-graph';

export default function GraphGenerator(payload) {
  const { data, width, height, container } = payload;
  const graph = ForceGraph()(container);
  graph
    .width(width)
    .height(height)
    .graphData(data)
    .linkDirectionalArrowLength(6)
    .dagMode('td')
    .dagLevelDistance(15)
    .zoom(5);
}
