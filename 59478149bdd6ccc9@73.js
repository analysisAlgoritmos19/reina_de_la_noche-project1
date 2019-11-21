// https://observablehq.com/@mbostock/exoplanets@73
export default function define(runtime, observer) {
  const main = runtime.module();
  main.variable(observer()).define(["md"], function(md){return(
md`D3

Please don't fail us :'(`
)});
  main.variable(observer()).define(["d3","DOM","size","pack","data","color"], function(d3,DOM,size,pack,data,color)
{
  const svg = d3.select(DOM.svg(size, size))
      .style("width", "100%")
      .style("height", "auto");

  const circle = svg.selectAll("circle")
    .data(pack(data).descendants().slice(1))
    .enter().append("circle")
      .attr("r", d => d.r)
      .attr("cx", d => d.x)
      .attr("cy", d => d.y);

  circle.filter(d => d.data)
      .attr("fill", d => color(d.data.radius))
    .append("title")
      .text(d => `${d.data.name}
Arboles iterados: ${d.data.radius}
Iteración: ${isNaN(d.data.distance) ? "N/A" : `${d.data.distance} pc`}`);

  circle.filter(d => d.children)
      .attr("fill", "none")
      .attr("stroke", "#000")
      .attr("stroke-width", 1.5);

  return svg.node();
}
);
  main.variable(observer("pack")).define("pack", ["d3","size","data"], function(d3,size,data)
{
  const pack = d3.pack().size([size, size]).padding(5);
  const planets = [{children: data.filter(d => d.distance === 0)}];
  const exoplanets = data.filter(d => d.distance !== 0);
  const root = {children: planets.concat(exoplanets)};
  return data => {
    return pack(d3.hierarchy(root)
      .sum(d => d.radius * d.radius)
      .sort((a, b) => {
        return !a.children - !b.children
            || isNaN(a.data.distance) - isNaN(b.data.distance)
            || a.data.distance - b.data.distance;
      }));
  };
}
);
  main.variable(observer("size")).define("size", function(){return(
954
)});
  main.variable(observer("color")).define("color", ["d3","data"], function(d3,data){return(
d3.scaleQuantize()
    .domain(d3.extent(data, d => d.radius))
    .range(["#156b87", "#876315", "#543510", "#872815"])
)});
  main.variable(observer("data")).define("data", ["d3"], function(d3){return(
d3.csv("sample.csv", ({name, radius, distance}) => ({name, radius: +radius, distance: distance ? +distance : NaN}))
)});
  main.variable(observer("d3")).define("d3", ["require"], function(require){return(
require("d3@5")
)});
  return main;
}
