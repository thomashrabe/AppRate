declare module '@capacitor/core' {
  interface PluginRegistry {
    AppRate: AppRatePlugin;
  }
}

export interface AppRatePlugin {
    rate(): Promise<{ value: string }>;
}
