import * as React from "react";
export interface RadarProps {
  title?: React.ReactNode;
  height: number;
  padding?: [number, number, number, number];
  hasLegend?: boolean;
  data: Array<{
    name: string;
    label: string;
    value: string;
  }>;
}

export default class Radar extends React.Component<RadarProps, any> {}
