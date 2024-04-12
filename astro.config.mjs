import { defineConfig } from 'astro/config';
import mdx from '@astrojs/mdx';

import sitemap from '@astrojs/sitemap';

const BASE_URL = "http://localhost:4321"
// https://astro.build/config
export default defineConfig({
	site: BASE_URL,
	base:'',
	integrations: [mdx(), sitemap()],
});
