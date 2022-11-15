# Http Cache

## Client Cache

Http client can maintain an http cache controlled by server through metadata sent
with response through headers 



## max-age

Server controls cache entry with max-age instruction.

Client can use local cache entry while max age is not reached.

After that it must revalidate.

-----------

<img src="MaxAge.png" alt="drawing" height="500"/>

## Conditional headers

Lightweight client cache revalidation for unchanged resources.

2 mechanisms :

   - Last modification timestamp
   - EntityTag : a short tag that signs resource content 

## Last-Modified 

<img src="LastModified.png" alt="drawing" height="500"/>


## ETag

<img src="Etag.png" alt="drawing" height="500"/>


## Conclusions
Keep Calm and let server control cache.


Make requests like a Billionaire. 
