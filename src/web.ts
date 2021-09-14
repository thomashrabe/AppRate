import { WebPlugin } from '@capacitor/core';
import { AppRatePlugin } from './definitions';

export class AppRateWeb extends WebPlugin implements AppRatePlugin {
  constructor() {
    super({
      name: 'AppRate',
      platforms: ['web', 'ios', 'andriod'],
    });
  }

  async rate(): Promise<{ value: string }> {
    console.log('APP RATE WEB');
    return {value: 'success'};
  }
}

const AppRate = new AppRateWeb();

export { AppRate };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(AppRate);
