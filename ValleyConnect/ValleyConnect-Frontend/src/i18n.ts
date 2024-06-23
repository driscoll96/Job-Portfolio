/* eslint-disable @typescript-eslint/no-unsafe-argument */
import {notFound} from 'next/navigation';
import {getRequestConfig} from 'next-intl/server';
import { locales } from './navigation';
 
// Can be imported from a shared config

 
export default getRequestConfig(async ({locale}) => {
  // Validate that the incoming `locale` parameter is valid
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  if (!locales.includes(locale as any)) notFound();
 
  return {
    // eslint-disable-next-line @typescript-eslint/no-unsafe-assignment, @typescript-eslint/no-unsafe-member-access
    messages: (await import(`../messages/${locale}.json`)).default
  };
});