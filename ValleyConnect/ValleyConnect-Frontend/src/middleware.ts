import createIntlMiddleware from 'next-intl/middleware';
import {locales} from './navigation';

export default createIntlMiddleware({
  locales,
  localePrefix: 'always',
  defaultLocale: 'en'
});

export const config = {
  // Skip all non-content paths
  matcher: ['/((?!api|_next|.*\\..*).*)']
};